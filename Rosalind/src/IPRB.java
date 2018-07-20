

// Finds probabilty of dominant phenotype, given counts of dominant homozygous,
// heterozygous, and recessive homozygous genotypes
public class IPRB {
	
	public static void main(String[] args) {
		double dominant = 19;
		double hetero = 18;
		double recessive = 16;
		
		double total = dominant + hetero + recessive;
		
		double probability = 0;
		
		// Dominant and Dominant
		probability += ( dominant / total) * ((dominant - 1) / (total - 1));
	
		// Dominant and Hetero
		probability += (dominant / total) * ((hetero) / (total - 1));
		
		// Hetero and Dominant
		probability += (hetero / total) * ((dominant) / (total - 1));
		
		// Dominant and Recessive
		probability += ( dominant / total) * ((recessive) / (total - 1));
		
		// Recessive and Dominant
		probability += (recessive / total) * ((dominant) / (total - 1));
		
		// Hetero and Recessive
		probability += ( hetero / total) * ((recessive) / (total - 1)) * (0.5);
		
		// Recessive and Hetero
		probability += ( recessive / total) * ((hetero) / (total - 1)) * (0.5);
		
		// Hetero and Hetero
		probability += (hetero / total) * ((hetero - 1) / (total - 1)) * (0.75);
		
		
		System.out.println("Probability of Dominant Phenotype: " + probability);
	}
}

