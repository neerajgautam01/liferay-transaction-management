/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sample.model.Address;
import com.liferay.sample.model.Employee;
import com.liferay.sample.model.impl.AddressImpl;
import com.liferay.sample.model.impl.EmployeeImpl;
import com.liferay.sample.service.base.EmployeeLocalServiceBaseImpl;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NeerajGautam
 * @see com.liferay.sample.service.base.EmployeeLocalServiceBaseImpl
 * @see com.liferay.sample.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	private static final Log LOG = LogFactoryUtil.getLog(EmployeeLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.EmployeeLocalServiceUtil} to access the employee local service.
	 */
	
	public void addEmployeerAddress() throws SystemException {
		LOG.info("Employeeinto..... saveSample");

		Employee employee = new EmployeeImpl();
		long employeeId = counterLocalService.increment(Employee.class.getName());
		employee.setEmployeeId(employeeId);

		employee = employeeLocalService.addEmployee(employee);
		LOG.info("addEmployeerAddress into...vvv..new.2.. saveSample");
		
		/**
		 * Inserting data to Address
		 */
		Address address = null;
		long addressId = counterLocalService.increment(Employee.class.getName());
		address.setAddressId(addressId);
		address.setEmployeeId(employee.getEmployeeId());
		addressLocalService.addAddress(address);
		LOG.info("addEmployeerAddress into...vvv..new.3.. saveSample");
	}
}