package ru.htp.ipetshop_ognivenko.controller.command;

import java.util.HashMap;
import java.util.Map;

import ru.htp.ipetshop_ognivenko.controller.command.impl.*;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandProvider() {
		
		commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
		commands.put(CommandName.LOCALIZATION, new LocalizationCommand());
		commands.put(CommandName.ADD_GOODS_TO_ORDER, new AddGoodsToOrderCommand());
		commands.put(CommandName.SEARCH_GOODS, new SearchGoodsCommand());
		commands.put(CommandName.PLACE_ORDER, new PlaceOrderCommand());
		commands.put(CommandName.GO_TO_BASKET, new GoToBasketCommand());
		commands.put(CommandName.EXIT, new ExitCommand ());
		commands.put(CommandName.GO_TO_ERROR_PAGE, new GoToErrorPage());
	}

	public Command getCommand(String name) {
		
		CommandName commandName = CommandName.valueOf(name.toUpperCase());

		Command command;
		command = commands.get(commandName);

		return command;
	}

}
