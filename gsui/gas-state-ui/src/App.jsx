import Button from '@material-ui/core/Button';
import axios from 'axios';
import './App.css';
import GasStateInput from './components/GasStateInput';
import GasStateTable from './components/GasStateTable';
import Header from './components/Header';

function App() {
  function submitGasStateRequest() {
    axios({
      method: 'post',
      url: 'http://localhost:8080/calculate',
      data: {
        firstInputType: 'TEMPERATURE',
        firstInputValue: 333,
        secondInputType: 'PRESSURE',
        secondInputValue: 0.00000969,
      },
    })
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  }

  return (
    <div className="container">
      <Header />
      <GasStateInput
        gasPropertyTypeId="temperature"
        gasPropertyTypeDisplay="Temperature (K)"
      />
      <GasStateInput
        gasPropertyTypeId="pressure"
        gasPropertyTypeDisplay="Pressure (Pa)"
      />
      <Button
        variant="contained"
        color="primary"
        style={
          {
            // fontSize: 24
          }
        }
        onClick={() => submitGasStateRequest()}
      >
        Calculate
      </Button>
      <GasStateTable />
    </div>
  );
}

export default App;
