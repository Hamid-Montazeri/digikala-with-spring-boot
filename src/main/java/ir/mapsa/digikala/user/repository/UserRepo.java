package ir.mapsa.digikala.user.repository;

import ir.mapsa.digikala.user.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {

}
