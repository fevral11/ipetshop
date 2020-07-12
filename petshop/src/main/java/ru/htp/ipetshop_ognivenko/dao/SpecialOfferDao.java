package ru.htp.ipetshop_ognivenko.dao;

public interface SpecialOfferDao {

	boolean addSpecialOffer(SpecialOfferDao specialOffer) throws DaoException;// добавляем новый вид скидки

	boolean applySpecialOffer(Integer idSpecialOffer, String typeGoods) throws DaoException;// применяем скидку ко всем
																							// товарам одного подвида

	boolean applySpecialOffer(Integer idSpecialOffer, GoodsDao goods) throws DaoException;// применяем скидку к
																							// отдельному товару

	boolean deleteSpecialOffer(SpecialOfferDao specialOffer) throws DaoException;// меняем статус скидки на удалена

}
