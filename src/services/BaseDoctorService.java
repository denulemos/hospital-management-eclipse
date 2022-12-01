package services;

import java.util.List;

import dao.DoctorDAO;
import exceptions.ServiceException;
import implementations.DoctorDAOImp;
import models.DoctorModel;


public abstract class BaseDoctorService {
	
	private DoctorDAO dao = new DoctorDAOImp();
	
	public void add(DoctorModel doctor) throws  ServiceException {
		try {
			dao.add(doctor);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
	
	public DoctorModel login(String id, String password) throws ServiceException {
		try {
			return dao.login(id, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServiceException();
		}
	}
	
	public List<DoctorModel> getBySpecialty(String specialty) throws ServiceException {
		try {
			return dao.getBySpecialty(specialty);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
	
	public List<DoctorModel> getByName(String fullName) throws ServiceException {
		try {
			return dao.getByName(fullName);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
	
	public DoctorModel getById(String id) throws ServiceException {
		try {
			return dao.getById(id);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
}
