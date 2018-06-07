package com.goosen1.controller;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goosen1.commons.annotations.GetMapping;
import com.goosen1.commons.annotations.ResponseResult;
import com.goosen1.commons.model.po.user.User;
import com.goosen1.commons.model.po.user.UserList;
import com.goosen1.commons.model.request.BaseDeleteReqData;
import com.goosen1.commons.model.request.BasePageReqData;
import com.goosen1.commons.model.request.user.UserAddReqData;
import com.goosen1.commons.model.request.user.UserUpdateReqData;
import com.goosen1.commons.model.response.BaseCudRespData;
import com.goosen1.commons.model.response.BaseListRespData;
import com.goosen1.commons.model.response.BaseModelRespData;
import com.goosen1.commons.model.response.BasePageRespData;
import com.goosen1.commons.model.response.user.UserList1;
import com.goosen1.commons.model.response.user.UserModel1;
import com.goosen1.commons.utils.BeanUtil;
import com.goosen1.commons.utils.CheckUtil;
import com.goosen1.commons.utils.IdGenUtil;
import com.goosen1.service.UserService;

/**
 * 用户管理
 * @author Goosen
 * 2018年6月6日-上午10:16:34
 */
@Api(value="用户管理",description="用户管理")
@RestController
@RequestMapping(value="person")
public class PersonController {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="添加用户4")
	@ResponseResult
//	@LoginAuth
	@RequestMapping(value = {"addUser4"},method=RequestMethod.POST)
	@Transactional(readOnly = false)
	public BaseCudRespData<String> addUser4(@Validated @RequestBody UserAddReqData userAddReqData) {
		
		log.info("进来addUser4<<<<<<<<<<<<<<<<<<<<");
		
		User user = new User();
		user.setId(IdGenUtil.uuid());
		BeanUtil.copyProperties(userAddReqData, user, "");
		userService.insert(user);
		
		BaseCudRespData<String> baseIdRespData = new BaseCudRespData<String>();
		baseIdRespData.setId(user.getId());
		
		return baseIdRespData;
	}
	
	@ApiOperation(value="修改用户")
	@ResponseResult
	@RequestMapping(value = {"updateUser"},method=RequestMethod.PUT)
	@Transactional(readOnly = false)
	public BaseCudRespData<String> updateUser(@Validated @RequestBody UserUpdateReqData userUpdateReqData) {
		
		log.info("进来updateUser<<<<<<<<<<<<<<<<<<<<");
		
		String id = userUpdateReqData.getId();
		User user = userService.get(id);
		CheckUtil.notNull(user, "id", "参数有误");
		BeanUtil.copyProperties(userUpdateReqData, user, "");
		user.setUpdateTime(new Date());
		userService.update(user);
		
		BaseCudRespData<String> baseIdRespData = new BaseCudRespData<String>();
		
		return baseIdRespData;
	}
	
	@ApiOperation(value="获取用户2")
	@ResponseResult
	@GetMapping
	@RequestMapping(value = {"getUser2"},method=RequestMethod.GET)
	public BaseModelRespData<UserModel1> getUser2(@ApiParam(name="id",value="用户id",required=true)String id) {
		
		log.info("进来getUser2<<<<<<<<<<<<<<<<<<<<");
		log.info("接收的参数：id："+id);
		
//		int i = 1/0;
		
//		String str = null;
//		CheckUtil.notNull(str, "str", "str不能空");
		
		BaseModelRespData<UserModel1> baseModelRespData = new BaseModelRespData<UserModel1>();
		User user = userService.get(id);
		UserModel1 userModel1 = new UserModel1();
		if(user != null)
			BeanUtil.copyProperties(user, userModel1, "");
//		userModel1.setGender("MALE");
//		userModel1.setNickname("郭靖");
		baseModelRespData.setModel(userModel1);
		
//		String words = userService.sayHello("hello!");
//		log.info("say:" + words);
		
		return baseModelRespData;
	}
	
	//分页
	@ApiOperation(value="获取用户列表1")
	@ResponseResult
	@GetMapping
	@RequestMapping(value = {"getUserList1"},method=RequestMethod.GET)
    public BasePageRespData<UserList1> getUserList1(BasePageReqData pageQO) {
        return userService.findAllUserListByPage(pageQO);
    }
	
	//不分页，全部
	@ApiOperation(value="获取全部用户列表1")
	@ResponseResult
	@GetMapping
	@RequestMapping(value = {"getAllUserList1"},method=RequestMethod.GET)
    public BaseListRespData<UserList1> getAllUserList1() {
		List<UserList1> userList = userService.findAllUserList();
		BaseListRespData<UserList1> baseListRespData = new BaseListRespData<UserList1>();
		baseListRespData.setList(userList);
        return baseListRespData;
    }
	
	@ApiOperation(value="删除用户1")
	@ResponseResult
	@RequestMapping(value = {"deleteUser1"},method=RequestMethod.DELETE)
	public BaseCudRespData<String> deleteUser1(@Validated @RequestBody BaseDeleteReqData<String> id) {
		
		log.info("进来deleteUser1<<<<<<<<<<<<<<<<<<<<");
		
		BaseCudRespData<String> baseIdRespData = new BaseCudRespData<String>();
		
		return baseIdRespData;
	}
	
}
