package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.annotation.SocialUser;
import com.allthatBTS.atbserver.user.domain.User;
import com.allthatBTS.atbserver.user.domain.enums.SocialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.allthatBTS.atbserver.user.domain.enums.SocialType.*;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserRepository userRepository;

    public UserArgumentResolver(){}

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(SocialUser.class) != null &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        //User user = (User)session.getAttribute("user");

//        HttpServletRequest httpRequest = (HttpServletRequest)webRequest.getNativeRequest();
//        HttpServletResponse httpResponse = (HttpServletResponse)webRequest.getNativeResponse();
//        Cookie cookie = WebUtils.getCookie(httpRequest, "loginCookie");

        return getUser();
    }

    private User getUser(){
        User user = null;
        try{
            OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            Map<String, Object> map = authentication.getPrincipal().getAttributes();
            User convertUser = convertUser(authentication.getAuthorizedClientRegistrationId(), map);

            user = userRepository.findByEmail(convertUser.getEmail());
            if(user == null) { user = userRepository.save(convertUser); }
            setRoleIfNotSame(user, authentication, map);
        } catch (ClassCastException e){
            e.printStackTrace();
        }

        return user;
    }

    private User convertUser(String authority, Map<String, Object> map){
        if(FACEBOOK.getValue().equals(authority)) return getModernUser(FACEBOOK, map);
        else if(GOOGLE.getValue().equals(authority)) return getModernUser(GOOGLE, map);
        else if(KAKAO.getValue().equals(authority)) return getKaKaoUser(map);
        return null;
    }

    private User getModernUser(SocialType socialType, Map<String, Object> map){
        return User.builder()
                .name(String.valueOf(map.get("name")))
                .email(String.valueOf(map.get("email")))
                //.principal(String.valueOf(map.get("id")))
                .socialType(socialType)
                .createdDate(LocalDateTime.now())
                .build();
    }

    private User getKaKaoUser(Map<String, Object> map){
        HashMap<String, String> propertyMap = (HashMap<String, String>)(Object)map.get("properties");
        return User.builder()
                .name(propertyMap.get("nickname"))
                .email(String.valueOf(map.get("kaccount_email")))
                //.principal(String.valueOf(map.get("id")))
                .socialType(KAKAO)
                .createdDate(LocalDateTime.now())
                .build();
    }

    private void setRoleIfNotSame(User user, OAuth2AuthenticationToken authentication, Map<String, Object> map){
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority(user.getSocialType().getRoleType())))
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(map, "N/A",
                AuthorityUtils.createAuthorityList(user.getSocialType().getRoleType())));
    }
}
