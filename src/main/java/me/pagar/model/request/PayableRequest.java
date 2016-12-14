package me.pagar.model.request;

import org.joda.time.DateTime;

import lombok.NoArgsConstructor;
import me.pagar.enumeration.PayableStatus;
import me.pagar.enumeration.PayableType;
import me.pagar.model.Payable;

@NoArgsConstructor
public class PayableRequest extends Payable implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 895108035961056434L;

	public PayableRequest(PayableStatus status, Integer amount, Integer fee, Integer installment, String transactionId,
			String splitRuleId, DateTime paymentDate, PayableType type) {
		super(status, amount, fee, installment, transactionId, splitRuleId, paymentDate, type);
	}

}
