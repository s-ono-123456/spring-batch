package com.example.batch.typehandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTypeHandler;

public class CustomLocalDateTypeHandler extends LocalDateTypeHandler {
	@Override
	public void setParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType) throws SQLException {
		if (Objects.isNull(parameter)) {
			ps.setNull(i, JdbcType.DATE.TYPE_CODE);
		} else {
			super.setParameter(ps, i, parameter, jdbcType);
		}
	}
}
