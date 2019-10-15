package com.woniuxy.l_lazyload;

import java.util.List;

public interface EmpMapper {
	List<Emp> findSomeByDid(Integer did);
}
