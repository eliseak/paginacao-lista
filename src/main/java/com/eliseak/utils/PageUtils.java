package com.eliseak.utils;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class PageUtils {

	//private static Logger logger = LogManager.getLogger(PageUtils.class);

	/**
	 * Calcula o total de paginas que uma lista possui dado um valor limite 
	 * de itens por pagina
	 * 
	 * @param lista a lista que deve ser paginada
	 * @param limite o limite de itens por pagina
	 * 
	 * @return numero total de paginas 
	 */
	public static Integer getTotalPages(List<?> lista, Integer limite) {
		return (int) Math.ceil( lista.size()/ limite.doubleValue() );
	}

	/**
	 * Faz a paginacao de uma lista e retorna uma sublista 
	 * com os itens de uma pagina. 
	 * O retorno é nulo quando o numero da pagina ultrapassa 
	 * o total de paginas possiveis.
	 * 
	 * @param lista a lista que deve ser paginada
	 * @param pagina a pagina desejada
	 * @param limite o limite de itens por pagina
	 * 
	 * @return lista com os itens pagina desejada
	 */
	public static List<?> getPageContent(
			List<?> lista, Integer pagina, Integer limite){

		if (!isValidPage(lista, pagina, limite)) {
			return null;
		}

		Integer inicio = ((pagina - 1) * limite);

		Integer itens = inicio + limite;

		// Código para evitar NullPointer no método de subList
		if (pagina == getTotalPages(lista, limite)) {
			itens = inicio + getCountLastPageItens(lista.size(), limite);

		}

		List<?> subList = lista.subList(inicio, itens);

		return subList;
	}


	/**
	 * Verifica se a pagina requerida e valida
	 * 
	 * @param lista lista a ser paginada
	 * @param pagina numero da pagina desejada
	 * @param limite numero de itens por pagina
	 */
	private static boolean isValidPage(
			List<?> lista, Integer pagina, Integer limite) {

		if (pagina <= 0) {
			return false;
		}

		Integer totalPaginas = getTotalPages (lista, limite);
		if (pagina > totalPaginas) {
			return false;
		}

		return true;
	}

	/**
	 * Retorna quantos itens teria a ultima pagina da lista
	 * 
	 * @param total total de itens da lista
	 * @param limite limite de itens por pagina
	 */
	private static Integer getCountLastPageItens(
			Integer total, Integer limite) {
		return total % limite;
	}

}
