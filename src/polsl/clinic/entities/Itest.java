package polsl.clinic.entities;

import javax.ejb.Local;


@Local
public interface Itest {

	public abstract String getAmount(double amount);

}