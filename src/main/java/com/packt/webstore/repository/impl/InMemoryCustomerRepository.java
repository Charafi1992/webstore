package com.packt.webstore.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Customer> getAllCostumers() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Customer> result = jdbcTemplate.query("select * from customers", params, new CustomerMapper());
		return result;
	}
	
	public void addCustomer(Customer customer) {
		String SQL = "INSERT INTO CUSTOMERS (ID,NAME,ADRESSE,NOMBRE_D_ACHAT) VALUES(:id,:name, :adresse, :numberOfOrder)";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id",customer.getCustomerId());
		params.put("name",customer.getName());
		params.put("adresse",customer.getAdress());
		params.put("numberOfOrder",customer.getNoOfOrdersMade());
		
		jdbcTemplate.update(SQL, params);
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	private static final class CustomerMapper implements RowMapper<Customer>{

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer Customer = new Customer();
			
			Customer.setCustomerId(rs.getString("ID"));
			Customer.setName(rs.getString("NAME"));
			Customer.setAdress(rs.getString("ADRESSE"));
			Customer.setNoOfOrdersMade(rs.getLong("NOMBRE_D_ACHAT"));
			return Customer;		
		}
		
	}
	
}
