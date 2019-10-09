/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2019-09-18
*/
public abstract class MesoAbstract extends MesoInherit
{
	public MesoAbstract(MesoStation mesoStation) {
		super(mesoStation);
	}

	//Abstract method calAverage to return integer array.
	public abstract int[] calAverage();

	//TODO: Create an abstract method letterAverage with return type char
	public abstract char letterAverage();
	
}
