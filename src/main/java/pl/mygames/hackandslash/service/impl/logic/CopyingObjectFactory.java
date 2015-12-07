package pl.mygames.hackandslash.service.impl.logic;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CopyingObjectFactory<T, V> {
	private static final Logger logger = LoggerFactory.getLogger(CopyingObjectFactory.class);
	

	public static <T extends Object, V extends Object> void makeTransferObject(T entity, V transferObject) {
		Class<? extends Object> entityClass = entity.getClass();
		Class<? extends Object> DTOClass = transferObject.getClass();
		
		Field[] fromEntityFields = entityClass.getDeclaredFields();
		Field[] toDTOFields = DTOClass.getDeclaredFields();
		
		Object valueObject = null;
		
//		if((fromEntityFields != null) (toDTOFields != null))
		for (Field entityField : fromEntityFields) {
			try {
				Field tempField = DTOClass.getDeclaredField(entityField.getName());
				valueObject = tempField.get(entity);
				tempField.set(transferObject, valueObject);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				logger.info(e.getMessage(), e);
			}
			
		}
	
	}
}
