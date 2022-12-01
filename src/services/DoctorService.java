package services;

import dao.DoctorDAO;
import implementations.DoctorDAOImp;

public class DoctorService extends BaseDoctorService {
	private static DoctorService instance;
	
	private DoctorService(DoctorDAO daoForEntity) {
		super();
	}
	
	public static DoctorService getInstance() {
		if (instance == null) {
			instance = new DoctorService(DoctorDAOImp.getInstance());
		}
		
		return instance;
	}
}
