package Arrays;

public class Basic {
	
	public static void main(String[] args) {
		//1.
		int arr[]= {1,2,3,4,5};
		for(int i:arr) {
			System.out.println(i);
		}
		//2.
		int a[]= {1,2,3,4};
		int sum=0;
		for(int j:a) {
			sum+=j;
		}
		System.out.println(sum);
		//3.
		int b[]= {2,4,6,8};
		int su=0;
		double avg=0;
		int n=a.length;
		for(int k:b) {
			su+=k;
			avg=su/n;
		}
		System.out.println(avg);
		//4.
		int c[]= {1,2,3,4,5};
		int largest=Integer.MIN_VALUE;
		for(int z:c) {
			if(z>largest) {
				largest=z;
			}
		}
		System.out.println(largest);
		
		//5.
		int d[]= {1,2,3,4,5};
		int even=0;
		int odd=0;
		for(int x:d) {
			if(x%2==0) {
				even++;
			}
			else {
				odd++;
			}
		}
		System.out.println(even);
		System.out.println(odd);
	
	}
	
}
