package com.key_stones.Security;



//import java.security.Permissions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.key_stones.ENUM.Permissions;

import com.key_stones.ENUM.Role;


public class RoleBasedPermission {
	
	public static Map<Role,Set<Permissions>>getRoleBasedPermissions(){
		
		Map<Role,Set<Permissions>>permission= new HashMap<>();
		permission.put(Role.ADMIN, new HashSet<Permissions>(Arrays.asList(Permissions.LOGIN,
				                                                           Permissions.LOGOUT,
				                                                           Permissions.CREATE_CUSTOMER,
				                                                           Permissions.UPDATE_CUSTOMER,
				                                                           Permissions.VIEW_CUSTOMER,
				                                                           Permissions.DELETE_CUSTOMER,
				                                                           Permissions.CREATE_USER,
				                                                           Permissions.UPDATE_USER,
				                                                           Permissions.VIEW_USER,
				                                                           Permissions.DELETE_USER,
				                                                           Permissions.CREATE_SITE,
				                                                           Permissions.UPDATE_SITE,
				                                                           Permissions.VIEW_SITE,
				                                                           Permissions.DELETE_SITE,
				                                                           Permissions.CREATE_WO,
				                                                           Permissions.UPDATE_WO,
				                                                           Permissions.VIEW_WO,
				                                                           Permissions.DELETE_WO,
				                                                           Permissions.CANCEL_WO,
				                                                           Permissions.ASSIGN_WO,
				                                                           Permissions.CLOSE_WO,
				                                                           Permissions.START_WORK,
				                                                           Permissions.HOLD_WORK,
				                                                           Permissions.RESUME_WORK,
				                                                           Permissions.COMPLETE_WORK,
				                                                           Permissions.HOLD_WORK,
				                                                           Permissions.ADD_PARTS,
				                                                           Permissions.UPDATE_PARTS,
				                                                           Permissions.USE_PARTS,
				                                                           Permissions.DELETE_PARTS,
				                                                           Permissions.ADD_TIME_LOGS,
				                                                           Permissions.VIEW_TIME_LOGS,
				                                                           Permissions.VIEW_DASHBOARD,
				                                                           Permissions.VIEW_REPORT,
				                                                           Permissions.SEND_NOTIFICATION
				                                                           )));
		
		
		permission.put(Role.MANAGER, new HashSet<Permissions>(Arrays.asList(Permissions.LOGIN,
                                                                            Permissions.LOGOUT,
                                                                            Permissions.CREATE_USER,
                                                                            Permissions.UPDATE_USER,
                                                                            Permissions.VIEW_USER,
                                                                            Permissions.CREATE_CUSTOMER,
                                                                            Permissions.UPDATE_CUSTOMER,
                                                                            Permissions.VIEW_CUSTOMER,
                                                                            Permissions.CREATE_SITE,
                                                                            Permissions.UPDATE_SITE,
                                                                            Permissions.VIEW_SITE,
                                                                            Permissions.CREATE_WO,
                                                                            Permissions.UPDATE_WO,
                                                                            Permissions.ASSIGN_WO,
                                                                            Permissions.CANCEL_WO,
                                                                            Permissions.VIEW_WO,
                                                                            Permissions.CLOSE_WO,
                                                                            Permissions.VIEW_DASHBOARD,
                                                                            Permissions.VIEW_REPORT,
                                                                            Permissions.VIEW_PARTS,
                                                                            Permissions.VIEW_TIME_LOGS,
                                                                            Permissions.SEND_NOTIFICATION)));
		
		
		permission.put(Role.DISPATCHER, new HashSet<Permissions>(Arrays.asList(Permissions.LOGIN,
                                                                               Permissions.LOGOUT,
                                                                               Permissions.VIEW_CUSTOMER,
                                                                               Permissions.VIEW_SITE,
                                                                               Permissions.CREATE_WO,
                                                                               Permissions.UPDATE_WO,
                                                                               Permissions.VIEW_WO,
                                                                               Permissions.ASSIGN_WO,
                                                                               Permissions.VIEW_DASHBOARD)));
		
		
		permission.put(Role.TECHNICIAN, new HashSet<Permissions>(Arrays.asList(Permissions.LOGIN,
                                                                               Permissions.LOGOUT,
                                                                               Permissions.VIEW_WO,
                                                                               Permissions.VIEW_SITE,
                                                                               Permissions.START_WORK,
                                                                               Permissions.HOLD_WORK,
                                                                               Permissions.RESUME_WORK,
                                                                               Permissions.COMPLETE_WORK,
                                                                               Permissions.VIEW_PARTS,
                                                                               Permissions.USE_PARTS,
                                                                               Permissions.ADD_TIME_LOGS,
                                                                               Permissions.VIEW_TIME_LOGS)));
		
		
		permission.put(Role.CUSTOMER, new HashSet<Permissions>(Arrays.asList(Permissions.LOGIN,
                                                                             Permissions.LOGOUT,
                                                                             Permissions.REQUEST_RAISE,
                                                                             Permissions.VIEW_OWN_REQUEST)));
		
		return permission;
		
		
                                                                               
		
		
                	

	}

}
