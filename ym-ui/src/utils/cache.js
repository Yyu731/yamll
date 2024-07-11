
class Cache {
  storage

  constructor(type) {
    this.storage = type === "local" ? localStorage : sessionStorage
  }

  setCache(key, value) {
    const v = JSON.stringify(value)
    if (v) {
      this.storage.setItem(key, JSON.stringify(value))
    }
  }

  getCache(key) {
    const value = this.storage.getItem(key)
    if (value) {
      return JSON.parse(value)
    }
  }

  removeCache(key) {
    this.storage.removeItem(key)
  }

  clear() {
    this.storage.clear()
  }
}

const localCache = new Cache("local")
const sessionCache = new Cache("session")

export { localCache, sessionCache }
