package ir.mapsa.digikala.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T, PK> extends PagingAndSortingRepository<T, PK> {

}
