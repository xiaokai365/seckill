package com.snail.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snail.sec.dto.BaseResponse;
import com.snail.sec.dto.SecKillInfo;
import com.snail.sec.dto.SecKillResult;
import com.snail.sec.entity.Secgoods;
import com.snail.sec.exception.RepeatSecKillException;
import com.snail.sec.exception.SecKillCloseException;
import com.snail.sec.exception.SecKillInfoModifyedException;
import com.snail.sec.service.SecgoodsService;

@Controller
@RequestMapping("seckill")
public class SecKillController {

	@Autowired
	private SecgoodsService secgoodsService;

	@RequestMapping(value = "/list", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<Secgoods> list = secgoodsService.queryall();
		model.addAttribute("list", list);
		return "list";
	}

	/**
	 * restful接口模式
	 * 
	 * @param secgoodsid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{secgoodsid}/detail", produces = {
			"application/json;charset=UTF-8" }, method = RequestMethod.GET)
	public String detail(@PathVariable("secgoodsid") Long secgoodsid, Model model) {
		Secgoods secgoods = secgoodsService.queryById(secgoodsid);
		model.addAttribute("secgoods", secgoods);
		return "detail";
	}

	@RequestMapping(value = "/{secgoodsid}/exposer", produces = {
			"application/json;charset=UTF-8" }, method = RequestMethod.POST)
	public BaseResponse<SecKillInfo> exposer(@PathVariable("secgoodsid") Long secgoodsid) {
		if (secgoodsid == null) {
			return new BaseResponse<>(false, "秒杀错误");
		}
		SecKillInfo secKillInfo = secgoodsService.exportSecKillUrl(secgoodsid);
		if (secKillInfo == null) {
			return new BaseResponse<>(false, "秒杀物品无效");
		}
		return new BaseResponse<SecKillInfo>(true, secKillInfo);
	}

	@RequestMapping(value = "/{secgoodsid}/{md5}/execute", produces = {
			"application/json;charset=UTF-8" }, method = RequestMethod.POST)
	public BaseResponse<SecKillResult> execute(@PathVariable("secgoodsid") Long secgoodsid,
			@PathVariable("md5") String md5, @CookieValue(value = "userphone", required = false) String userphone) {
		if (secgoodsid == null || md5 == null) {
			return new BaseResponse<SecKillResult>(false, "执行秒杀错误");
		}
		try {
			SecKillResult killResult = secgoodsService.executeSecKill(secgoodsid, userphone, md5);
			return new BaseResponse<SecKillResult>(true, killResult);
		} catch (SecKillInfoModifyedException e) {
			return new BaseResponse<SecKillResult>(false, "秒杀信息被篡改");
		} catch (RepeatSecKillException e) {
			return new BaseResponse<SecKillResult>(false, "重复秒杀");
		} catch (SecKillCloseException e) {
			return new BaseResponse<SecKillResult>(false, "秒杀结束");
		} catch (Exception e) {
			return new BaseResponse<SecKillResult>(false, "内部错误");
		}
	}

}
