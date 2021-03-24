package com.umi.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.umi.service.OtherService;

@Service
public class OtherServiceImpl implements OtherService{

	private Logger log = Logger.getLogger(OtherServiceImpl.class);
	
	@Override
	public void getVaildCode(HttpSession session,HttpServletResponse resp) {
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_BGR);
		Graphics2D gra= image.createGraphics();
		gra.setColor(Color.WHITE);
		gra.fillRect(0, 0, 200, 100);
		
		Random random = new Random();
		String code = getRandomVaild(4, VAILD_ALPH);
		char[] list = code.toCharArray();
		
		gra.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,40));
		Color[] colors = new Color[]{Color.RED,Color.BLUE,Color.green,Color.GRAY,Color.BLACK,Color.orange};
		for(int i=0;i<list.length;i++){
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(list[i]+"", i*50, 70+random.nextInt(21)-10);
		}
		for(int i=0;i<2;i++){
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
		}
		
		try {
			ServletOutputStream os = resp.getOutputStream();
			ImageIO.write(image, "png", os);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		session.setAttribute("code", code);
	}

	@Override
	public boolean getPhoneVaildCode(String smsMode,String phoneNum,HttpSession session) {
		String phoneValid = getRandomVaild(OtherService.PHONE_VALID_NUM,VAILD_NUMBER);
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
				"LTAI4FcKmZVWcrdvv3jyb9UC", 
				"RZraiowQOFq4c4MMU050sMNSWjuefp");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "羽未汐");
        request.putQueryParameter("TemplateCode", smsMode);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+phoneValid+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            Map parse = (Map)JSONArray.parse(response.getData());
            if(parse.get("Message").equals("OK")){
            	session.setAttribute("phoneValid", phoneValid);
            	log.info("手机号："+phoneNum+"发送手机验证码成功");
            	return true;
            }
            log.error("验证码发送失败");
            log.error(response.getData());
        } catch (ServerException e) {
        	log.error(e.getMessage());
        } catch (ClientException e) {
        	log.error(e.getMessage());
        }
        return false;
	}
	
	/**
	 * 获取指定长度的随机验证码
	 * @param vaildNum
	 * @return
	 */
	public String getRandomVaild(int vaildNum,String type){
		String[] vailds = new String[]{"0","1","2","3","4","5","6","7","8","9"};
		String[] vailds2 = new String[]{"a","b","c","d","e","f","g","h","i","g","k","l","m","n","o",
				"p","q","r","s","t","u","v","w","x","y","z"};
		String[] vailds3 = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","g","k","l","m","n","o",
				"p","q","r","s","t","u","v","w","x","y","z"};
		
		String rtnStr = "";
		Random random = new Random();
		switch(type){
			case VAILD_ALPH:
				for(int i=0;i<vaildNum;i++){
					rtnStr+=vailds2[random.nextInt(vailds2.length)];
				}
				break;
			case VAILD_MIX:
				for(int i=0;i<vaildNum;i++){
					rtnStr+=vailds3[random.nextInt(vailds3.length)];
				}		
				break;
			default:
				for(int i=0;i<vaildNum;i++){
					rtnStr+=vailds[random.nextInt(vailds.length)];
				}
				break;
		}
		
		return rtnStr;
	}

}
