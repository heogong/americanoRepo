package com.americano.foundation.user.biz;

import com.americano.foundation.user.domain.RoleDomain;

public interface RoleBiz {
	RoleDomain findByRole(String role);
}
