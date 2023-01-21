package s25535.s25535Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {

    @Mock
    private ClientStorage clientStorage;

    @InjectMocks
    private BankService bankService;

    @Test
    void cashTransferDeniedWhenClientNotExist() {
        //given
        when(clientStorage.getClientById(any())).thenReturn(null);

        //when
        TransferInfo testInfo = bankService.cashTransfer("notExistingClient", 100);

        //then
        assertThat(testInfo).hasToString(
                "TransferInfo{currentAmmount=0.0," +
                        " transactionStatus=DECLINED}");
    }
    @Test
    void cashTransferWhenAmmountOfMoneyBelow0() {
        //given
        when(clientStorage.getClientById(any())).thenReturn(new Client("Jan",100));

        //when
        TransferInfo testInfo = bankService.cashTransfer("Jan", 0);

        //then
        assertThat(testInfo).hasToString(
                "TransferInfo{currentAmmount=100.0," +
                        " transactionStatus=DECLINED}");
    }

    @Test
    void addMoneyToBalanceDeniedWhenClientNotExist() {
        //given
        when(clientStorage.getClientById(any())).thenReturn(null);

        //when
        TransferInfo testInfo = bankService.addMoneyToBalance("notExistingClient", 200);

        //then
        assertThat(testInfo).hasToString(
                "TransferInfo{currentAmmount=0.0," +
                        " transactionStatus=DECLINED}");
    }
    @Test
    void addMoneyToBalanceDeniedWhenAmmountOfMoneyBelow0() {
        //given
        when(clientStorage.getClientById(any())).thenReturn(new Client("Jan",300));

        //when
        TransferInfo testInfo = bankService.cashTransfer("Jan", 0);

        //then
        assertThat(testInfo).hasToString(
                "TransferInfo{currentAmmount=300.0," +
                        " transactionStatus=DECLINED}");
    }
}
