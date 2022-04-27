package br.com.aragy.patterns.factoryMethod;

public class GetPlanFactory {
	
	public Plan getPlan(String planType) {		
		if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) 
			return new InstitutionalPlan();	
		else 
			if(planType.equalsIgnoreCase("DOMESTICPLAN")) 
				return new DomesticPlan();
			else
				if(planType.equalsIgnoreCase("COMERCIALPLAN"))
					return new ComercialPlan();
				else 
					return null;	
		
	}

}
