package effyis.rdv.payment.integration.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import effyis.rdv.payment.CmiMockServiceApplication;
import effyis.rdv.payment.dto.BillersResponseDTO;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.util.SecurityUtil;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CmiMockServiceApplication.class)
public class BillerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Value("${security.hash.secret}")
	private String secret;

	// without biller category
	// @Test
	public void getAllBillersTest() throws Exception {

		String MAC = URLEncoder.encode(
				SecurityUtil.calculateHashMAC("BCP", "15", "20200813172654", "5", "", "123456789123", "2", this.secret),
				StandardCharsets.UTF_8);
		String url = "/EFFYIS/api/cmi/creanciers?typeCanal=2&aquereurID=BCP&modeID=5&canalID=15&dateServeur=20200813172654&refTxSysPmt=123456789123&MAC="
				+ MAC;
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		BillersResponseDTO response = mapper.readValue(result.getResponse().getContentAsString(),
				BillersResponseDTO.class);
		String expectedMac = SecurityUtil.calculateBillersSendMAC(response.getCodeRetour(), response.getDateServeur(),
				response.getListeCreanciers(), this.secret);
		Assertions.assertEquals(ReturnCode.C000.getReturnCode(), response.getCodeRetour());
		Assertions.assertEquals(ReturnCode.C000.getComment(), response.getMsg());
		Assertions.assertEquals(2, response.getNbreCreancier());
		Assertions.assertEquals(expectedMac, response.getMAC());
	}

	// test when hash not correct && without biller category
	// @Test
	public void getAllBillersHashErrorTest() throws Exception {

		String url = "/EFFYIS/api/cmi/creanciers?typeCanal=2&aquereurID=BCP&modeID=5&canalID=15&dateServeur=20200813172653&refTxSysPmt=123456789124&MAC=hY4gFbBI3GfCp2rKsDiwBw==";
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		BillersResponseDTO response = mapper.readValue(result.getResponse().getContentAsString(),
				BillersResponseDTO.class);
		String expectedMac = SecurityUtil.calculateBillersSendMAC(response.getCodeRetour(), response.getDateServeur(),
				response.getListeCreanciers(), this.secret);
		Assertions.assertEquals(ReturnCode.C100.getReturnCode(), response.getCodeRetour());
		Assertions.assertEquals(ReturnCode.C100.getComment(), response.getMsg());
		Assertions.assertEquals(0, response.getNbreCreancier());
		Assertions.assertNotEquals(expectedMac, response.getMAC());
	}

	// with biller category
	// @Test
	public void getBillersByCategoryTest() throws Exception {

		String MAC = URLEncoder.encode(
				SecurityUtil.calculateHashMAC("BCP", "15", "20200813172654", "5", "", "123456789123", "2", this.secret),
				StandardCharsets.UTF_8);
		String url = "/EFFYIS/api/cmi/creanciers?typeCanal=2&aquereurID=BCP&modeID=5&canalID=15&dateServeur=20200813172654&refTxSysPmt=123456789123&MAC="
				+ MAC + "&categorieCreance=1";
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		BillersResponseDTO response = mapper.readValue(result.getResponse().getContentAsString(),
				BillersResponseDTO.class);
		String expectedMac = SecurityUtil.calculateBillersSendMAC(response.getCodeRetour(), response.getDateServeur(),
				response.getListeCreanciers(), this.secret);
		Assertions.assertEquals(ReturnCode.C000.getReturnCode(), response.getCodeRetour());
		Assertions.assertEquals(ReturnCode.C000.getComment(), response.getMsg());
		Assertions.assertEquals(1, response.getNbreCreancier());
		Assertions.assertEquals(expectedMac, response.getMAC());
	}

	// with category does not exist
	@Test
	public void getBillersByCategoryInexistantTest() throws Exception {

		String MAC = URLEncoder.encode(
				SecurityUtil.calculateHashMAC("BCP", "15", "20200813172654", "5", "", "123456789123", "2", this.secret),
				StandardCharsets.UTF_8);
		String url = "/EFFYIS/api/cmi/creanciers?typeCanal=2&aquereurID=BCP&modeID=5&canalID=15&dateServeur=20200813172654&refTxSysPmt=123456789123&MAC="
				+ MAC + "&categorieCreance=5";
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		BillersResponseDTO response = mapper.readValue(result.getResponse().getContentAsString(),
				BillersResponseDTO.class);
		Assertions.assertEquals(ReturnCode.C112.getReturnCode(), response.getCodeRetour());
		Assertions.assertEquals(ReturnCode.C112.getComment(), response.getMsg());
		Assertions.assertEquals(0, response.getNbreCreancier());
	}

	// canal type does not exist && with biller category
	@Test
	public void getBillersByCanalInexistantTest() throws Exception {

		String MAC = URLEncoder.encode(
				SecurityUtil.calculateHashMAC("BCP", "15", "20200813172654", "5", "", "123456789123", "5", this.secret),
				StandardCharsets.UTF_8);
		String url = "/EFFYIS/api/cmi/creanciers?typeCanal=5&aquereurID=BCP&modeID=5&canalID=15&dateServeur=20200813172654&refTxSysPmt=123456789123&MAC="
				+ MAC + "&categorieCreance=1";
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		BillersResponseDTO response = mapper.readValue(result.getResponse().getContentAsString(),
				BillersResponseDTO.class);
		Assertions.assertEquals(ReturnCode.C113.getReturnCode(), response.getCodeRetour());
		Assertions.assertEquals(ReturnCode.C113.getComment(), response.getMsg());
		Assertions.assertEquals(0, response.getNbreCreancier());
	}
}
