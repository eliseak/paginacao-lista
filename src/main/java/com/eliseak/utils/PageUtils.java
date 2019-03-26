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
	 * @param list a lista que deve ser paginada
	 * @param limit o limite de itens por pagina
	 * 
	 * @return numero total de paginas 
	 */
	public static Integer getTotalPages(List<?> list, Integer limit) {
		return (int) Math.ceil( list.size()/ limit.doubleValue() );
	}

	/**
	 * Faz a paginacao de uma lista e retorna uma sublista 
	 * com os itens de uma pagina. 
	 * O retorno e nulo quando o numero da pagina ultrapassa 
	 * o total de paginas possiveis.
	 * @param <T> o tipo do item na lista
	 * 
	 * @param list a lista que deve ser paginada
	 * @param page a pagina desejada
	 * @param limit o limite de itens por pagina
	 * 
	 * @return lista com os itens pagina desejada
	 */
	public static <T> List<T> getPageContent(
			List<T> list, Integer page, Integer limit){

		if (!isValidPage(list, page, limit)) {
			return null;
		}

		// Variavel que indica o inicio da sublista
		Integer fromIndex = ((page - 1) * limit);

		// Variavel que indica o fim da sublista
		Integer toIndex = fromIndex + limit;

		// Codigo para evitar NullPointer no metodo de subList
		if (page == getTotalPages(list, limit)) {
			toIndex = fromIndex + getCountLastPageItens(list.size(), limit);

		}

		return list.subList(fromIndex, toIndex);
	
	}

	/**
	 * Verifica se a pagina requerida e valida
	 * 
	 * @param list lista a ser paginada
	 * @param page numero da pagina desejada
	 * @param limit numero de itens por pagina
	 */
	private static boolean isValidPage(
			List<?> list, Integer page, Integer limit) {

		if (page <= 0) {
			return false;
		}

		Integer totalPages = getTotalPages (list, limit);
		if (page > totalPages) {
			return false;
		}

		return true;
	}

	/**
	 * Retorna quantos itens teria a ultima pagina da lista
	 * 
	 * @param total total de itens da lista
	 * @param limit limite de itens por pagina
	 */
	private static Integer getCountLastPageItens(
			Integer total, Integer limit) {
		return total % limit;
	}

}
