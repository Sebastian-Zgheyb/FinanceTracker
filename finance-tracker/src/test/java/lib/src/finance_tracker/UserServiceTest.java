package lib.src.finance_tracker;

import lib.src.finance_tracker.model.AppUser;
import lib.src.finance_tracker.repository.UserRepository;
import lib.src.finance_tracker.service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        AppUser user = new AppUser();
        user.setUsername("testuser");
        user.setPassword("testpass");

        when(userRepository.save(any(AppUser.class))).thenReturn(user);

        AppUser createdUser = userService.save(user);

        assertEquals("testuser", createdUser.getUsername());
        assertEquals("testpass", createdUser.getPassword());
        verify(userRepository, times(1)).save(user);
    }
}
