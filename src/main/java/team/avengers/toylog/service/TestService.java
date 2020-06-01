package team.avengers.toylog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.avengers.toylog.model.TestResponseDto;
import team.avengers.toylog.persistence.h2.repository.TestRepository;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<TestResponseDto> getAllTests() {
//        return testRepository.findAll();
        // TODO: 2020-06-01 결과물을 List가 아니고 ResponseApi 형태로 래핑해서 반환할 수 있도록 common 같은 패키지 만들어서..? 알지?
        return null;
    }
}
