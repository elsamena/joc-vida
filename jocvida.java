import java.util.Scanner;
public class JocDeLaVida {

	Scanner entrada=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		JocDeLaVida p= new JocDeLaVida();
		p.principal();
	}
	
	public  void principal() {
		
		System.out.println("Introdueix el número de files:");
		int numf=Llegir();
		
		System.out.println("Introdueix el número de columnes:");
		int numc=Llegir();
		
		int Etapa1[][]=new int [(numf+2)][(numc+2)];
		int Etapa2[][]=new int [(numf+2)][(numc+2)];
		
		System.out.println("Quants grups voldreu introduïr?");
		int numg=Llegir();
		
	
		GenerarMarge( numf,  numc,  Etapa1);
		int randomfila=0, randomcolumna=0;
		
		boolean verif=false;
		while(!verif) {
				 randomfila= (int)(Math.random()*(1+(Etapa1.length-1))+1);
				 randomcolumna=(int)(Math.random()*(1+(Etapa1.length-1))+1);
				
				if((randomcolumna>0 && randomcolumna<Etapa1.length) && (randomfila>0 && randomfila<Etapa1.length)) {
					verif=true;
				}
		}
		
			
			Etapa1[randomfila][randomcolumna]=1;
			Imprimir(Etapa1);
			System.out.println();
			GenerarVeins(Etapa1, randomfila, randomcolumna);
			
			Imprimir(Etapa1);
			System.out.println();
			int cont=0;
			
			while(cont<50) {
			Evolucio(Etapa1);
			
			Imprimir(Etapa1);
			System.out.println();
			cont++;
			}
			
			
			
			
			
			
		
	
		
	}
	
	public int Llegir(){
		int num;
		num=entrada.nextInt();
		
		return num;
	}
	public static void GenerarMarge(int numf, int numc, int Etapa1[][]) {
		for(int i=0;i<numf+2;i++) {
			for(int j=0;j<numc+2;j++) {
				
				 if(i==0 || j==0) {
					 Etapa1[i][j]=0;
				 }
				 if(i==(numf+1)||j==(numc+1)) {
					 Etapa1[i][j]=0;
				 }
	}
	}
	}
	public static void GenerarVeins(int Etapa1[][], int randomfila, int randomcolumna) {
		int contveins=0;
		int randomveins=0;
		
		if((randomfila!=0 && randomcolumna!=0)&&(randomfila!=Etapa1.length && randomcolumna!=Etapa1.length)) {
            while(contveins<4){
		
					
					
                if((randomfila!=0 && randomcolumna!=0) && (randomfila!=Etapa1.length && randomcolumna!=Etapa1.length)) {
                    
                if(randomfila<Etapa1.length-1 && randomcolumna<Etapa1.length-1) {
                if(randomfila+1<Etapa1.length && randomcolumna+1<Etapa1.length) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        Etapa1[randomfila+1][randomcolumna+1]=1;
                        contveins++;
                    }
                }
                if(randomfila+1>0) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila+1][randomcolumna]=1;
                    }
                }
                if(randomfila+1<Etapa1.length && randomcolumna-1>0) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila+1][randomcolumna-1]=1;
                    }
                }
                if(randomcolumna+1<Etapa1.length) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila][randomcolumna+1]=1;
                    }
                }
                if (randomcolumna-1>0) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila][randomcolumna-1]=1;
                    }
                }
                if(randomfila-1>0 && randomcolumna-1>0) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila-1][randomcolumna-1]=1;
                    }
                }
                if(randomfila-1>0) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila-1][randomcolumna]=1;
                    }
                }
                if(randomfila-1>0 && randomcolumna+1<Etapa1.length) {
                    randomveins=(int)(Math.random()*2);
                    
                    if(randomveins==1) {
                        contveins++;
                        Etapa1[randomfila-1][randomcolumna+1]=1;
                    }
                }
                }
                }
                
            
                
        }

    
    }
}
public static void Evolucio(int Etapa1[][]) {
    int contv=0;
    for(int i=0;i<Etapa1.length;i++) {
        for(int j=0;j<Etapa1.length;j++) {
            contv=0;
            
            if((i!=0 && j!=0) && (i!=Etapa1.length && j!=Etapa1.length)) {
                
            if(i<Etapa1.length-1 && j<Etapa1.length-1) {
            
            if(Etapa1[i+1][j+1]==1) {
                contv++;
            }
            if(Etapa1[i+1][j]==1) {
                contv++;
            }
            if(Etapa1[i+1][j-1]==1) {
                contv++;
            }
            if(Etapa1[i][j+1]==1) {
                contv++;
            }
            if(Etapa1[i][j-1]==1) {
                contv++;
            }
            if(Etapa1[i-1][j+1]==1) {
                contv++;
            }
            if(Etapa1[i-1][j]==1) {
                contv++;
            }
            if(Etapa1[i-1][j-1]==1) {
                contv++;
            }
        if(contv<=1) {
            Etapa1[i][j]=0;
        }
        if(contv>=4) {
            Etapa1[i][j]=0;
        }
        if( contv==3) {
            Etapa1[i][j]=1;
        }
        
        if(contv==2 && Etapa1[i][j]==1) {
            Etapa1[i][j]=1;
        }
        else {
            Etapa1[i][j]=0;
        }
        
    }
            }
        }
    }
}
public static void Imprimir(int Etapa1[][]) {
		
    for(int i=0;i<Etapa1.length;i++) {
        for(int j=0;j<Etapa1.length;j++) {
            System.out.print(Etapa1[i][j]+" ");
        }
        System.out.println();
    }

}
}