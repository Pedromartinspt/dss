package eu.europa.esig.dss.validation.process.vpfswatsp.checks.psv.checks;

import eu.europa.esig.dss.jaxb.detailedreport.XmlPCV;
import eu.europa.esig.dss.jaxb.detailedreport.XmlPSV;
import eu.europa.esig.dss.validation.MessageTag;
import eu.europa.esig.dss.validation.policy.rules.Indication;
import eu.europa.esig.dss.validation.policy.rules.SubIndication;
import eu.europa.esig.dss.validation.process.ChainItem;
import eu.europa.esig.jaxb.policy.LevelConstraint;

public class PastCertificateValidationCheck extends ChainItem<XmlPSV> {

	private final XmlPCV pcv;

	public PastCertificateValidationCheck(XmlPSV result, XmlPCV pcv, LevelConstraint constraint) {
		super(result, constraint);

		this.pcv = pcv;
	}

	@Override
	protected boolean process() {
		return isValid(pcv);
	}

	@Override
	protected MessageTag getMessageTag() {
		return MessageTag.PSV_IPCVC;
	}

	@Override
	protected MessageTag getErrorMessageTag() {
		return MessageTag.PSV_IPCVC_ANS;
	}

	@Override
	protected Indication getFailedIndicationForConclusion() {
		return pcv.getConclusion().getIndication();
	}

	@Override
	protected SubIndication getFailedSubIndicationForConclusion() {
		return pcv.getConclusion().getSubIndication();
	}

}