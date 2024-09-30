package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myCrewMember implements CrewMember{

		private int age;
		private int yearsInService;
		private String name;
		
		public myCrewMember(int age, int yearsInService, String name){
			this.age = age;
			this.name = name;
			this.yearsInService = yearsInService;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getAge() {
			return this.age;
		}

		@Override
		public int getYearsInService() {
			return this.yearsInService;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			myCrewMember other = (myCrewMember) obj;
			return Objects.equals(name, other.name);
		}

		
}
