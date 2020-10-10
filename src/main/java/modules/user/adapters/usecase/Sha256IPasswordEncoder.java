package modules.user.adapters.usecase;

import modules.user.ports.usecase.IPasswordEncoder;

public class Sha256IPasswordEncoder implements IPasswordEncoder {
	@Override
	public String encode(final String str) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(str);
	}
}
