package ku.message.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTResponse
{
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private String expiresIn;

	@JsonProperty("token_type")
	private String tokenType;
}
