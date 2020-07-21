package board.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import board.user.user.User;

@Component
@Mapper
public interface UserMapper {
	
	User findUserByLoginId(@Param("loginId") String loginId);
    int setUserInfo(@Param("param") User param);
}
