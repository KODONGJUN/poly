package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfoMapper {
    //회원 가입하기 (회원정보 등록하기)
    int insertUserInfo(UserInfoDTO pDTO) throws Exception;
    //회원가입전 중복 체크
    UserInfoDTO getUserExists(UserInfoDTO pDTO) throws Exception;

































    UserInfoDTO getUserLoginCheck(UserInfoDTO pDTO);
}
