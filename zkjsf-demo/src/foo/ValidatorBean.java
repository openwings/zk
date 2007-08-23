/* ValidatorBean.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2007/8/22  3:01:00 PM     2007, Created by Dennis.Chen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package foo;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Dennis.Chen
 *
 */
public class ValidatorBean {

	Date value = new Date();

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public void validateDate(FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
		Date date = (Date)value;
		if(date==null) return;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if(day!=Calendar.SATURDAY && day!=Calendar.SUNDAY){
			throw new ValidatorException(new FacesMessage("Select day of weekend only"));
		}
	}
	
	public String doSubmit(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Process value after validation:"+value));
		return null;
	}
	
	
}
