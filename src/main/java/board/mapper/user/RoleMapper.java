package board.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import board.user.user.Role;

@Component
@Mapper
public interface RoleMapper {
	Role getRoleInfo(@Param("role") String role);
}
