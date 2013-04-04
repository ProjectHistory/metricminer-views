package app.csv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class CSVParser {

	public <T> List<T> parse(Class<T> clazz, String text) {
		
		try {
			String[] lines = text.split("\n");
			List<T> list = new ArrayList<T>();
			
			for(String line : lines) {
				String[] content = line.split(";");
				
				T newMetric = (T) clazz.newInstance();
				for(int i = 0; i < content.length; i++) {
					fill(newMetric, content, i);
				}
				
				list.add(newMetric);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private <T> void fill(T newMetric, String[] content, int position) throws IllegalArgumentException, IllegalAccessException {
		String value = content[position].replace("\"", "");
		
		Field[] fields = newMetric.getClass().getFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(Position.class)) {
				Position p = (Position) field.getAnnotation(Position.class);
				if(p.position() == position+1) {
					if (field.getType().isAssignableFrom(Integer.TYPE)) {
						field.set(newMetric, Integer.valueOf(value));
					}
					else if (field.getType().isAssignableFrom(Double.TYPE)) {
						field.set(newMetric, Double.valueOf(value));
					}
					else if (field.getType().isAssignableFrom(String.class)) {
						field.set(newMetric, value);
					}
				}
			}
		}
		
	}
}
