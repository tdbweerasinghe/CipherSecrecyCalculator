package password_demo;


public class SecrecyCalculator
{
	
	private static int[] countByteDistribution(byte[] data, int start, int length)
	{
		final int[] countedData = new int[256];

		for (int i=start; i<start+length; i++)
		{
			countedData[data[i] & 0xFF]++;
		}

		return countedData;
	}

	
	private static double log2(double d)
	{
		return Math.log(d)/Math.log(2.0);
	}

	
	public static double calculateEntropy(byte[] data, int start, int length)
	{
		double entropy = 0;

		final int[] countedData = countByteDistribution(data, start, length);

		for (int i=0;i<256;i++)
		{
			final double p_k = 1.0 * countedData[i] / length;

			if (p_k > 0)
			{
				entropy += -p_k * log2(p_k);
			}
		}
                
		return entropy;
	}

	
	public static double[] entropy_scan(byte[] input, int blockSize)
	{
		final double[] entropies = new double[input.length - blockSize];

		for (int i=0;i<input.length - blockSize;i++)
		{
			entropies[i] = calculateEntropy(input, i, blockSize);
		}

		return entropies;
	}

        public static double calculateSecrecy(byte[] key, byte[] cipher, int start)
	{
		double entropy = 0;
                double secrecy = 0;

                System.out.println("\n\t\tKey Length: " + key.length);
                //System.out.println("\n\t\tCipher Length: " + cipher.length);

		final int[] countedKey = countByteDistribution(key, start, key.length-1);
                final int[] countedCipher = countByteDistribution(cipher, start, cipher.length-1);


                for (int i=0;i<256;i++)
		{
			final double p_k = 1.0 * countedKey[i] / key.length;
                        final double p_c = 1.0 * countedCipher[i] / cipher.length;

			if (p_k > 0)
			{
				entropy += p_k * log2(p_k);
                                secrecy += -p_c * entropy;
			}
		}

		return secrecy;
	}
	
	      
}
