package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String>{
	
	@Override	
	public String transform(String _email)
	{
		return _email.concat("@gajdzio.com");
	}
	
	
	

}
