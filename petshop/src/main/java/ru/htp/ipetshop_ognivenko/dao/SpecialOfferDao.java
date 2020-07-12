package ru.htp.ipetshop_ognivenko.dao;

public interface SpecialOfferDao {

	boolean addSpecialOffer(SpecialOfferDao specialOffer) throws DaoException;// ��������� ����� ��� ������

	boolean applySpecialOffer(Integer idSpecialOffer, String typeGoods) throws DaoException;// ��������� ������ �� ����
																							// ������� ������ �������

	boolean applySpecialOffer(Integer idSpecialOffer, GoodsDao goods) throws DaoException;// ��������� ������ �
																							// ���������� ������

	boolean deleteSpecialOffer(SpecialOfferDao specialOffer) throws DaoException;// ������ ������ ������ �� �������

}
