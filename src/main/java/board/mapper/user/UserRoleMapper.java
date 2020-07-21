package board.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import board.user.user.UserRole;

@Component
@Mapper
public interface UserRoleMapper {
	void setUserRoleInfo(@Param("param") UserRole param);
}
