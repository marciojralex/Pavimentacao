package exercicio2;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacao { 

	//Textos pré-definidos
	private static final String umaNota = "Fatura da nota fiscal de simples remessa: ";
	//Identificador da entidade
	private String texto;
		
	//Gera observações, com texto pre-definido, incluindo os números, das notas fiscais, recebidos no parâmetro
	public String gerarObservacao(List lista) 
	{
		texto = "";
		if (!lista.isEmpty()) 
		{
			return retornarCodigos(lista) + ".";
		}		
		return "";		
	}

	//Cria observação
	private String retornarCodigos(List lista) {
		if (lista.size() >= 2) {
			texto = "Fatura das notas fiscais de simples remessa: ";
		} else {
			texto = umaNota;
		}
		
		StringBuilder cod = gerarConteudo(lista);
		
		return texto + cod;
	}
        
        //Acha separador
        private StringBuilder gerarConteudo(List lista){
            StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if( cod.toString() == null || cod.toString().length() <= 0 )
				s =  "";
				else if( iterator.hasNext() )
					s =  ", ";
				else
					s =  " e ";
			
			cod.append(s + c);
		}
                return cod;
        }
        
}