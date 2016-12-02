package me.pagar.model.request;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.Payable;

@NoArgsConstructor
public class PayableRequest extends Payable implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 895108035961056434L;

	@Builder
	public PayableRequest(String status, String amount, String fee, String installment, String transactionId,
			String splitRuleId, String paymentDate, String type) {
		super(status, amount, fee, installment, transactionId, splitRuleId, paymentDate, type);
	}
}
