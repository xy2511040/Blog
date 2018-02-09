package cn.jsmoon.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.jsmoon.entity.Blogger;
import cn.jsmoon.service.BloggerService;

/**
 * 自定义Realm
 * @author LTQ
 *
 */
public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private BloggerService bloggerService;
	
	/**
	 * 给登录用户赋予角色权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 验证登录用户角色权限
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String userName= (String) token.getPrincipal();
		Blogger blogger = bloggerService.getByUserName(userName);
		if(blogger!=null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), "jsmoon");
			return authcInfo;
		}else{
			return null;
			
		}
	}

}
