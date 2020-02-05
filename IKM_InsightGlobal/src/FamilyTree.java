import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FamilyTree {
	static final int NAME_LENGTH=10;
	static Set<Person> parents;
	static List<Person> hierarchy;
	static Set<String> claiment;
	static Person founder;
	static int famRel;
	static int noOfClaim;


	public static void main(String[] args) {
		//read data
		//create relation tree
		readData();
		
		// get nearest hierarchy
		System.out.println(getHierarchy());
	}

	private static void readData() {
		Scanner scanData = new Scanner(System.in);
		try {

			if(scanData.hasNextInt())
				famRel=scanData.nextInt();
			noOfClaim = scanData.nextInt();

			if((famRel< 1 || famRel > 50) && (noOfClaim < 1 || noOfClaim>50)){
				System.out.println("Invalid inputs");
			}else {
				parents = new LinkedHashSet<Person>();
				hierarchy = new ArrayList<Person>();
				claiment = new TreeSet<String>();

				String name = scanData.next();
				scanData.nextLine();

				founder = new Person(name);
				founder.setRoyalBlood(1);
				//founder.setParents(null);

				parents.add(founder);

				while(famRel > 0) {
					String relNames= scanData.nextLine();
					String [] child = relNames.toString().split(" ");

					Person childNode = new Person(checkName(child[0].toString().toLowerCase()));
					//List<Person> parent = new ArrayList<Person>();
					Person fp = new Person(checkName(child[1].toString()));
					Person sp = new Person(checkName(child[2].toString()));
					/*
					 * double fpRb =0; double spRb=0;
					 */
					
					
					/*
					 * for(Person person:parents) { if(person.name.equals(child[1].toString())) {
					 * spRb=0; if(child[1].equals(founder.name)) fpRb = person.royalBlood; else {
					 * fpRb = person.royalBlood/2; } fp.royalBlood=fpRb; }
					 * if(person.name.equals(child[2].toString())) { fpRb=0;
					 * if(child[2].equals(founder.name)) spRb=person.royalBlood; else {
					 * spRb=person.royalBlood/2; } sp.royalBlood=spRb; }
					 * 
					 * }
					 */
					Person p =findParents(child[1].toString());
					if(p!=null) {
						fp=p;
					}
					
					p =findParents(child[2].toString());
					if(p!=null) {
						sp=p;
					}
					
					childNode.royalBlood=(fp.royalBlood+sp.royalBlood)/2;

					/*
					 * if(child[1].equals(founder.name) || child[2].equals(founder.name)){
					 * fp.parents=null; sp.parents=null; }
					 */

					/*
					 * parent.add(fp); parent.add(sp); childNode.setParents(parent);
					 */
					
					hierarchy.add(childNode);
					parents.add(fp);
					parents.add(sp);
					parents.add(childNode);

					famRel--;
				}
				while(noOfClaim >0) {
					claiment.add(scanData.next());
					noOfClaim--;
				}
				
				/************/

				System.out.println("Children");
				for(Person person:hierarchy)
				{
					System.out.println(person.name +" : "+person.royalBlood);
				}
				
				System.out.println("Parents");
				for(Person person:parents)
				{
					System.out.println(person.name +" : "+person.royalBlood);
				}

				System.out.println("Potential heirs");
				System.out.println(claiment);
			/********************/	
			}
		}catch(Exception e) {
			System.out.println("Exception reading data "+e.getMessage());
			scanData.close();
		}
	}

	private static Person findParents(String name) {
		  for(Person person:parents) { 
			  if(person.name.equals(name))
		   return person;
		  }
		return null;
	}

	private static String checkName(String name) throws Exception {
		if(name.length()<10 && !(name.isEmpty()))
			return name;
		else
			throw new Exception();
	}

	private static String getHierarchy() {
		String heir=null;
		double maxRB = 0;
		for(Person person:hierarchy)
		{
			for(String heirName : claiment) {
				if(person.name.equals(heirName))
				{
					if(person.royalBlood>maxRB)
					{
						heir=heirName;
						maxRB=person.royalBlood;
					}
				}
			}
		}

		return heir;
	}

	public static class Person{
		private String name;
		private double royalBlood;
		//private List<Person> parents;

		public double getRoyalBlood() {
			return royalBlood;
		}

		public void setRoyalBlood(double royalBlood) {
			this.royalBlood = royalBlood;
		}

		/*
		  public List<Person> getParents() { return parents; }
		  
		  public void setParents(List<Person> parents) { this.parents = parents; }*/
		 

		public Person(String name) {
			this.name = name;
		}

	}
}

