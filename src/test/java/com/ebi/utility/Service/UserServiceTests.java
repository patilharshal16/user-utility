package com.ebi.utility.Service;

import com.ebi.utility.repository.UserRepository;
import com.ebi.utility.util.transformers.UserTransformer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UserServiceTests {

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserTransformer userTransformer;

    @Test
    public void verifyLocalRepositoryCountTest()
    {
        UserRepository localMockRepository = Mockito.mock(UserRepository.class);
        Mockito.when(localMockRepository.count()).thenReturn(1L);

        long userCount = localMockRepository.count();

        Assertions.assertEquals(1L, userCount);
        Mockito.verify(localMockRepository).count();
    }

}
