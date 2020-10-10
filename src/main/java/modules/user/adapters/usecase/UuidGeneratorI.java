package modules.user.adapters.usecase;

import modules.user.ports.usecase.IIdGenerator;

import java.util.UUID;

public class UuidGeneratorI implements IIdGenerator {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
