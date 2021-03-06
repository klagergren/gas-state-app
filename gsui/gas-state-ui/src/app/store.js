import { configureStore } from '@reduxjs/toolkit';
import inputReducer from '../redux/slices/inputSlice';

export default configureStore({
  reducer: {
    input: inputReducer,
  },
});
