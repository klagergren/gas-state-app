import './App.css';
import Button from '@material-ui/core/Button';
import Select from '@material-ui/core/Select';
import Header from './components/Header';
import GasStateInput from './components/GasStateInput';

function App() {
  return (
    <div className="container">
      <Header />
      <GasStateInput />
      <GasStateInput />
      <Button
        variant="contained"
        color="primary"
        style={
          {
            // fontSize: 24
          }
        }
        onClick={() => console.log('Hello')}
      >
        Calculate
      </Button>
    </div>
  );
}

export default App;
